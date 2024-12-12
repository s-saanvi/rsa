package rsa; 
import java.util.Scanner; 
import java.math.BigInteger; 
public class rsa { 
 
    public static void main(String args[]) { 
     Scanner sc = new Scanner(System.in); 
 
        // Input prime numbers p and q 
        System.out.println("Enter two prime numbers:"); 
        int p = sc.nextInt(); 
        int q = sc.nextInt(); 

        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q)); 
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1)); 
 
        System.out.println("Enter the value for e:"); 
        BigInteger e = sc.nextBigInteger(); 
        while (!phi.gcd(e).equals(BigInteger.ONE)) { 
            System.out.println("Enter a valid value for e:"); 
            e = sc.nextBigInteger(); 
        } 
 
        BigInteger d = e.modInverse(phi); 
        System.out.println("d value is " + d); 
 
        System.out.println("Enter plain text (number):"); 
        BigInteger m = sc.nextBigInteger(); 

        BigInteger c = m.modPow(e, n); 
        System.out.println("Cipher text is: " + c); 

        BigInteger decryptedM = c.modPow(d, n); 
        System.out.println("Decrypted text is: " + decryptedM); 
 
        if (decryptedM.equals(m)) { 
            System.out.println("Input matched"); 
        } else { 
            System.out.println("Input mismatched"); 
        } 
 
        sc.close(); 
    }  
    
} 
