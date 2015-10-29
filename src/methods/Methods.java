
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

package methods;

public abstract class Methods {
	public static long conversorA(int a, int b, int c, int d) {
		long aL = a * 16777217L; 
    	long bL = b * 65536L;
        long cL = c * 256L;
        long dL = d * 1L;
        long convA = aL + bL + cL + dL;
        
        return convA;
	}
			
	public static int host(int m) {
        double hostTotal = Math.pow(2, m);
        int hostInt = (int)hostTotal;
                      
        return hostInt;
        
    }
    
    public static long salto(long dir, int hostTol, int numSub) {
        int salto = hostTol * numSub;
        long res = dir + salto;
        
        return res;
    }
            
    public static String conversorB (long num) {
        long w = num / 16777217;
        long w1 = num % 16777217;
        long x = w1 / 65536;
        long x1 = w1 % 65536;
        long y = x1 /256;
        long z = x1 % 256;
        String resul = w + "." + x + "." + y + "." + z;
        
        return resul;
    }
    
    public static void info(int totSubInt, int subUsa, int n) {
    	System.out.print("\nNumero total de subredes: " + totSubInt);
        System.out.print("\nNumero de subredes usables: " + subUsa);
        System.out.println("\nNumero de bits prestados: " + n);
    }
    
    public static int n(int subredes){
        int n = 1;
                
        for(int i = 2; i < subredes; i *= 2)
            n++;
               
        return n;
    }
    
    public static int m(int subredes){
        int m = 1;
                
        for(int i = 2; i < subredes; i *= 2)
            m++;
               
        return m;
    }
    
    public static double totSub(int n) {
    	double totSub = Math.pow(2, n);
    	int nI = (int)totSub;
    	return nI;
    }
    
    

}