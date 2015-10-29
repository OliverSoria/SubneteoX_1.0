
/*

This file is part of "SubneteoX 1.0".

"SubneteoX 1.0" is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

"SubneteoX 1.0" is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
"SubneteoX 1.0"

*/

package logic;

public class Prefix extends Dir{
	public long dir;
    public int prefix;
    public int m;
    public int mask;
    public String n;
    public double totSub;
    char clase;
    String masPre;
    String masPer;
    long subTot;
    long subUsa;
    long hosTot;
    long hosUsa;
    
    public Prefix() {}
    
    public Prefix (String aS, String bS, String cS, String dS) {
    	int a = Integer.parseInt(aS);
    	int b = Integer.parseInt(bS);
    	int c = Integer.parseInt(cS);
    	int d = Integer.parseInt(dS);
    	
    	long aL = a * 16777217L; 
    	long bL = b * 65536L;
        long cL = c * 256L;
        long dL = d * 1L;
        dir = aL + bL + cL + dL;
    }
    
    public Prefix (int aI, int bI, int cI, int dI) {
    	long aL = aI * 16777217L; 
    	long bL = bI * 65536L;
        long cL = cI * 256L;
        long dL = dI * 1L;
        dir = aL + bL + cL + dL;
    }
    
    public int m(int pfx) {
    	m = 0;
    	m = 32 - pfx;
    	return m;
    }
    
    public String n(long direc, int m) {
    	int n1 = 0;
    	if(direc >= 3221225664L && dir <= 3758096606L) { // x x x o
            n1 = 32 - (24 + m);
        } else if (direc >= 2147483776L && dir <= 3221225662L) { // x x o o
            n1 = 32 -(16 + m);
        } else if (direc >= 16777217L && dir <= 2147483774L) { // x o o o
            n1 = 32 - (8 + m);
        }
    	n = Integer.toString(n1);
    	return n;
    }
    
    
    
    public String clas(long direc) {
    	String cl = null;
    	if(direc >= 3221225664L && dir <= 3758096606L) { // Clase C
            cl = "C";
        } else if (direc >= 2147483776L && dir <= 3221225662L) { // Clase B
        	cl = "B";
        } else if (direc >= 16777217L && dir <= 2147483774L) { // Clase A
        	cl = "A";
        }
    	
    	return cl;
    }
    
    public String total(String n2) {
    	
    	double n3 = Double.parseDouble(n2);
    	double ts1 = Math.pow(2, n3);
    	int ts = (int)ts1;
    	String tsS = String.valueOf(ts);
    	
    	return tsS;
    }
    
    public String usable(String n2) {
    	
    	double n3 = Double.parseDouble(n2);
    	double ts1 = Math.pow(2, n3);
    	int ts = (int)ts1;
    	ts -= 2;
    	String tsS = String.valueOf(ts);
    	
    	return tsS;
    }

    public String totalH(int n4) {
	
	//int n3 = (int)n4;
	double ts1 = Math.pow(2, n4);
	int ts = (int)ts1;
	String tsS = String.valueOf(ts);
	
	return tsS;
	}

    public String usableH(int n4) {
	
	int n3 = (int)n4;
	double ts1 = Math.pow(2, n3);
	int ts = (int)ts1;
	ts -= 2;
	String tsS = String.valueOf(ts);
	
	return tsS;
	}

    public String mPre(long direc) {
	String mPre = null;
	if(direc >= 3221225664L && dir <= 3758096606L) { // x x x o
        mPre = "255.255.255.0";
    } else if (direc >= 2147483776L && dir <= 3221225662L) { // x x o o
    	mPre = "255.255.0.0";
    } else if (direc >= 16777217L && dir <= 2147483774L) { // x o o o
    	mPre = "255.0.0.0";
    }
	
	return mPre;
	}

    public String convertir(int x) {
	String res = String.valueOf(x);
	return res;
	}
    
public String mask(String nS) {
    int n = Integer.parseInt(nS);  
	int mask1 = 0; 
        
	if (n == 1 || n == 9 || n == 17) {
			mask1 = 128;
        } else if (n == 2 || n == 10 || n == 18) {
        	mask1 = 192;
        } else if (n == 3 || n == 11 || n == 19) {
        	mask1 = 224;
        } else if (n == 4 || n == 12 || n == 20) {
        	mask1 = 240;
        } else if (n == 5 || n == 13 || n == 21) {
        	mask1 = 248;
        } else if (n == 6 || n == 14 || n == 22) {
        	mask1 = 252;
        } else if (n == 7 || n == 15) {
        	mask1 = 254;
        } else if (n == 8 || n == 16) {
        	mask1 = 255;
        }
        String mask1S = convertir(mask1);
        return mask1S;
        
        }

public String maskPerso(long conv, String maskS, String nS) {
	String mP = null;
	int mask = Integer.parseInt(maskS);
	int n = Integer.parseInt(nS);
	
	
	if (conv >= 1677717L && conv <= 2147483774L) {
	if (n < 9) {
                mP = "255." + mask + ".0" + ".0";
            }else if(n > 8 && n < 17){
                mP = "255.255." + mask + ".0";
            }else if(n > 16) {
                mP = "255.255." + "255." + mask;
            }
        } else if (conv >= 2147483776L && conv <= 3221225662L) {
            if (n < 9) {
                mP = "255.255." + mask + ".0";
            } else if (n > 8) {
                mP = "255.255." + "255." + mask;
            }
        } else if (conv >= 3221225664L && conv <= 3758096606L) {
           mP = "255.255.255." + mask;
        } 
	
	return mP;
	
	}

	public static long salto(long dir, int hostTol, int numSub) {
		int salto = hostTol * numSub;
		
		long res = dir + salto;
		return res;
	}

	public static String conversor (long num) {
		long w = num / 16777217;
		long w1 = num % 16777217;
		long x = w1 / 65536;
		long x1 = w1 % 65536;
		long y = x1 /256;
		long z = x1 % 256;
		String resul = w + "." + x + "." + y + "." + z;
		
		return resul;
	}
         
 
}
