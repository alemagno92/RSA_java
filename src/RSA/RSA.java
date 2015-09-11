package RSA;

import java.math.BigInteger;

public class RSA {

	private clsBigInteger n, d, e;
	private int longitud	, fiabilidad;

	public RSA(int longitud, int fiabilidad) {
		this.longitud = longitud;
		this.fiabilidad = fiabilidad;
		generarClaves();
	}

	public RSA(clsBigInteger d, clsBigInteger n) {
		this.d = d;
		this.n = n;
	}

	public clsBigInteger encriptar(clsBigInteger mensaje) {
		BigInteger aux = new BigInteger("0");
		aux = mensaje.potenciaMod(mensaje.toBigInteger(), e.toBigInteger(),
				n.toBigInteger());
		return new clsBigInteger(aux.toString());
	}

	public clsBigInteger desencriptar(clsBigInteger mensaje) {
		BigInteger aux = new BigInteger("0");
		aux = mensaje.potenciaMod(mensaje.toBigInteger(), d.toBigInteger(),
				n.toBigInteger());
		return new clsBigInteger(aux.toString());
	}

	public void generarClaves() {
		BigInteger aux = new BigInteger("0");
		clsBigInteger p = new clsBigInteger("1");
		p = p.generaPrimo(longitud, this.fiabilidad);
		// System.out.println("p : "+p);
		clsBigInteger q = new clsBigInteger("1");
		q = q.generaPrimo(longitud, this.fiabilidad);
		// System.out.println("q: "+q);
		aux = p.multiply(q);
		n = new clsBigInteger(aux.toString());
		// System.out.println("n: "+n);
		aux = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		clsBigInteger m = new clsBigInteger(aux.toString());
		// System.out.println("m (fi) = "+m);
		aux = new BigInteger("3");
		while (m.euclides(new clsBigInteger(aux.toString())).intValue() != 1) {
			aux = aux.add(new BigInteger("2"));
		}
		// System.out.println("e = "+aux.toString());
		e = new clsBigInteger(aux.toString());
		aux = e.modInverse(m);
		d = new clsBigInteger(aux.toString());
		// System.out.println("d = "+aux.toString());
	}

	public clsBigInteger getN() {
		return this.n;
	}

	public clsBigInteger getD() {
		return this.d;
	}

}
