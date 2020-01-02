package org.spring.utils.job;

import org.junit.Test;
import org.utils.RSAUtils;

import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

public class RSATest {

    @Test
    public void testEncrypt() {
        try {
            Map<String, String> keys = RSAUtils.generatorKeys();
            String publicKey = keys.get("publicKey");
            String privateKey = keys.get("privateKey");

            System.out.println("公钥：" + publicKey);
            System.out.println("私钥：" + privateKey);

            String result = RSAUtils.encrypt("123456789", publicKey);
            System.out.println("加密后: " + result);

            result = testDecrypt(result, privateKey);
            System.out.println("解密后：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDecrypt() {
        try {
            String source = "d26LiITN5kAeRvCWJyB6jkhlSY1RLxlg0ZS0AalVGWreNuAezecYGej2pbArAnvfEzj7nNnZIuvDCtnVXDp4dis04IRzpX+xprQMb3WDHiS0o20aJBTQfmR7pNJvQ0E7UIuiX3RJ9DS986YXvIPBTTjV3L/tJE5nYLCwkUElRLA=";
            String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM5uU6bmIVVXeUTS\n" +
                    "kNQIe5ClMFhu5y4UgS1bJ7gV7Tqe5NIoMetA0AgAlSIlQQ1G0Wov85uAQWtvlRxh\n" +
                    "aYsXWx62SNDyqjubZcA3ouDPxZGD+SZ4us2LX1kT7cAyzQEduSYN+lLyshmcDjXe\n" +
                    "ljpbHxCbmMdvOG9dkHLIfh2P9LapAgMBAAECgYEAl4q4kEpa6BqqJNLrjSyZAWuz\n" +
                    "HQh1YAefeRt1Ahfeqm0hEAJ/+vL+hRFgacutgMCfVXPUQzCZVfR5I3eDkp9XvNZ+\n" +
                    "8ARYmcLi5psw8HxkSuknncW3/gEa0BL9t1MKWhiZRf2AZ0FW76pz2UhAV2frkci7\n" +
                    "R22hM0bNMQAsLbqFwnECQQD47zsj0By0SZyj5HFw0j9vM6y5achnExOLTFQjiJpo\n" +
                    "n1lPWPsqXvGMskmfsQehT7dzeiFanr3HvPQuG9vDXvxtAkEA1EpDYj8eW4D/FyC4\n" +
                    "sr9I4PJ0YceFVz9s+sMtUhiAgmUNTPHCyi5MNYC2vgGLiwRXivfXdckdfYnaQX69\n" +
                    "s24FrQJBAKNCGlIpebnPkTh3aOKqMMoYZM4RD0pyW13/CCtpuoKlByif3dFzBQ3W\n" +
                    "G6zsqGll45WLYnaRJzvos2fOA3oFQJ0CQGG/UAeMyI2Zd9tOVbz4FrZ87NmY5Oyn\n" +
                    "Z6aO9+81GPbxUI59QxOU/cIk4f/a9kWsWiLCu5KgZ9PGBZjiorZbkoECQBDt9gZZ\n" +
                    "ixXDafQyXdWnH2HR7x/GzHXRdT7oL08gipYm9kf5oubwhLLnY3EUro1s4P6iMbdQ\n" +
                    "stDXkRv+kCXikeI=";
            String result = RSAUtils.decrypt(source, privateKey);
            System.out.println("解密后: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String testDecrypt(String source, String privateKey) {
        try {
            return RSAUtils.decrypt(source, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
