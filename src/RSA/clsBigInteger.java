package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class clsBigInteger extends BigInteger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public clsBigInteger(String valor) {
		super(valor);
	}

	public clsBigInteger(byte[] bytes) {
		super(bytes);
	}

	public BigInteger toBigInteger() {
		BigInteger aux = this;
		return aux;
	}

	public clsBigInteger mod(clsBigInteger modulo) {
		BigInteger resto = new clsBigInteger("0");

		resto = this.subtract(modulo.multiply(this.divide(modulo)));
		return new clsBigInteger(resto.toString());

	}

	public clsBigInteger potenciaMod(clsBigInteger base,
			clsBigInteger exponente, clsBigInteger modulo) {
		clsBigInteger resultado = new clsBigInteger("1");

		for (int k = exponente.bitLength() - 1; k >= 0; k--) {
			resultado = (clsBigInteger) (resultado.multiply(resultado))
					.mod(modulo);
			if (exponente.testBit(k)) {
				resultado = (clsBigInteger) (resultado.multiply(base))
						.mod(modulo);
			}
		}
		return resultado;
	}

	public clsBigInteger potencia(clsBigInteger exponente) {
		BigInteger aux = new BigInteger("1");
		System.out.println(exponente.byteValue());

		for (int i = exponente.byteValue() - 1; i >= 0; i--) {
			aux = aux.multiply(this);
			System.out.println(aux.toString());
		}
		return new clsBigInteger(aux.toString());
	}

	public clsBigInteger generaPrimo(int longitud, int fiabilidad) {
		SecureRandom azar = new SecureRandom();
		BigInteger primo;
		do {
			primo = new BigInteger(longitud / 2, 20, azar);

			// System.out.println(""+primo.toString());
		} while (esPrimo(new clsBigInteger(primo.toString()), fiabilidad));
		return new clsBigInteger(primo.toString());
	}

	public boolean esPrimo(clsBigInteger primo, int fiabilidad) {
		boolean resp = true;
		BigInteger aux = new BigInteger("0");
		for (int j = 1; j < fiabilidad; j++) {
			aux = randomBigInteger(this);
			BigInteger resto = new BigInteger(potenciaMod(aux,
					primo.subtract(BigInteger.ONE), (BigInteger) this)
					.toString());
			if (aux.compareTo(resto) != 1)
				resp = false;
		}

		return resp;
	}

	public static BigInteger randomBigInteger(BigInteger n) {
		Random rnd = new Random();
		int maxNumBitLength = n.bitLength();
		BigInteger aRandomBigInt;
		do {
			aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
			// compare random number lessthan ginven number
		} while (aRandomBigInt.compareTo(n) > 0);
		return aRandomBigInt;
	}

	public BigInteger potenciaMod(BigInteger base, BigInteger exponente,
			BigInteger modulo) {
		BigInteger resultado = BigInteger.ONE;

		for (int k = exponente.bitLength() - 1; k >= 0; k--) {
			resultado = (resultado.multiply(resultado)).mod(modulo);
			if (exponente.testBit(k)) {
				resultado = (resultado.multiply(base)).mod(modulo);
			}
		}
		return resultado;
	}

	// devuelve el mcd (a,b) a= this, b =b;
	public clsBigInteger euclides(clsBigInteger b) {
		clsBigInteger aux, temp, resto;
		aux = this;
		temp = b;
		if (aux.compareTo(temp) < 0) {
			temp = aux;
			aux = b;
		}
		while (temp.compareTo(BigInteger.ZERO) != 0) {
			resto = aux.mod(temp);
			aux = temp;
			temp = resto;
		}
		return aux;
	}
	/*
	 * public void inverso(clsBigInteger b){ BigInteger s = new BigInteger("1");
	 * BigInteger s1 = new BigInteger("0"); BigInteger t = new BigInteger("0");
	 * BigInteger t1 = new BigInteger("1"); clsBigInteger aux = this;
	 * clsBigInteger temp = b; BigInteger r = new BigInteger("0"); BigInteger q
	 * = new BigInteger("0"); while(temp.compareTo(BigInteger.ZERO)!=0){ r =
	 * aux.mod(temp); q = aux.divide(temp); aux=temp; s=s1; t=t1; temp = new
	 * clsBigInteger(r.toString()); s1 = s.subtract(s1.multiply(q)); t1 =
	 * t.subtract(t1.multiply(q)); } System.out.println("r : "+r.toString());
	 * System.out.println("q : "+q.toString());
	 * System.out.println("aux : "+aux.toString());
	 * System.out.println("temp : "+temp.toString());
	 * System.out.println("s1 : "+s1.toString());
	 * System.out.println("t1 : "+t1.toString());
	 * System.out.println("s : "+s.toString());
	 * System.out.println("t : "+t.toString());
	 * 
	 * 
	 * 
	 * }
	 */
}
