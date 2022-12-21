import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Crypto {
    public static PublicKey pub;
    public static PrivateKey pvt;

    public static void generateKeyPair(){
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        KeyPairGenerator generator = null;

        try {
            generator = KeyPairGenerator.getInstance("EC");
            generator.initialize(ecSpec, new SecureRandom());
            KeyPair keyPair = generator.generateKeyPair();
            pub = keyPair.getPublic();
            pvt = keyPair.getPrivate();
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e){
            e.printStackTrace();
        }
    }

    public static boolean verify(Message message, String sender){
        Signature ecdsa = null;
        try{
            ecdsa = Signature.getInstance("SHA256withECDSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(sender));
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            ecdsa.initVerify(publicKey);
            ecdsa.update(message.body.getBytes(StandardCharsets.UTF_8));
            return ecdsa.verify(Base64.getDecoder().decode(message.signature));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e){
            e.printStackTrace();
        }
        return false;
    }

    public static Message sign(Message message){
        Signature ecdsa = null;
        try{
            ecdsa = Signature.getInstance("SHA256withECDSA");
            ecdsa.initSign(pvt);
            ecdsa.update(message.body.getBytes(StandardCharsets.UTF_8));
            byte[] signature = ecdsa.sign();
            String sig = Base64.getEncoder().encodeToString(signature);
            message.signature = sig;
            message.signer = getPublicKey();
            return message;
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPublicKey(){
        return Base64.getEncoder().encodeToString(pub.getEncoded());
    }
}
