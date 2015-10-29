
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

public class RedReq extends Prefix {
	public long dir;
	public int n;
	public String m;
	int redesReq;
	
	public RedReq (String aS, String bS, String cS, String dS) {
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
	
	public int n(int subredes){
        int n = 1;
                
        for(int i = 2; i < subredes; i *= 2)
            n++;
               
        return n;
    }
	
	public String m(long direc, int ene) {
    	int n1 = 0;
    	if(direc >= 3221225664L && dir <= 3758096606L) { // x x x o
            n1 = 32 - (24 + ene);
        } else if (direc >= 2147483776L && dir <= 3221225662L) { // x x o o
            n1 = 32 -(16 + ene);
        } else if (direc >= 16777217L && dir <= 2147483774L) { // x o o o
            n1 = 32 - (8 + ene);
        }
    	m = Integer.toString(n1);
    	return m;
    }
	
	public String deCon(String ip) {
		String[] ss = ip.split("\\.");
		int px = 0 ;
		int[] oct = new int[ss.length];

	    for (int i = 0; i < ss.length; i++) {
	        try {
	            oct[i] = Integer.parseInt(ss[i]);
	        } catch (NumberFormatException nfe) {};
	    }
	    
	    String a = Integer.toBinaryString(oct[0]);
	    a += Integer.toBinaryString(oct[1]); 
	    a += Integer.toBinaryString(oct[2]);
	    a += Integer.toBinaryString(oct[3]);
	        
	    char[] charArray = a.toCharArray();
	    
	    for (char i:charArray) {
	    	if (i == '1') {
	    		px++;
	    	}
	    }
						
		String pxS = String.valueOf(px);
		return pxS;
	}

}
