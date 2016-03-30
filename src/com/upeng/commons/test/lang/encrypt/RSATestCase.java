package com.upeng.commons.test.lang.encrypt;

import junit.framework.TestCase;

import com.upeng.commons.lang.encrypt.RSA;

public class RSATestCase extends TestCase {
	
	public static void testDecode(){
		String key1="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLTEk4kRaAZCMmBnoWr0MKFVWFwqRRc+6C+oU7fxYCP51+HpBEV434rvMHj4IdcyST2wKaVCg1dWVgrR9SLRPLeLvcM51P6pRQxfvJIOlQT12l+sgtQi4kzrluAMBRfbkW8+/HRZ4yL7dE60U8rjOSgf1aV4UNkRjaPomYqiA6EQIDAQAB";
		String key2="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAItMSTiRFoBkIyYGehavQwoVVYXCpFFz7oL6hTt/FgI/nX4ekERXjfiu8wePgh1zJJPbAppUKDV1ZWCtH1ItE8t4u9wznU/qlFDF+8kg6VBPXaX6yC1CLiTOuW4AwFF9uRbz78dFnjIvt0TrRTyuM5KB/VpXhQ2RGNo+iZiqIDoRAgMBAAECgYAwJGth63L1aKZlK/PiByyKPZlTI1Qa+pBCIEcPqvp2SHor7nA5znC4s+42fLihaPwJRbX+lHtZDnu9D9g1VHL0Zbp6/b4Li+2nZ92qX+ybtZHaSPIjR73oxc+BWA2/WaVOHBnJQrDqbhBnkCuWpaGep0KnmKapTULHMCyhHoFqgQJBAPqRwLGqVQxR/asqPLHzy+4Ynp4AXow0am9UhWHkz9anTmbexY5zp5CbOk7N1yk2pNKOCvVb7VUTwWjKbdnpmMkCQQCOUSkXMoH0guRBh0++eMmjpHfVzVfVUKNL1nwq3A5C/Yg/N2tpEHzvO/x/0CJNLHDOXba9nfLG5zsdodtSY4MJAkAU6tv6OOz2pVWW12TPujl4++cp63/5FlsYRicIYBCVq8vYvJojZTZE1SCN+ZMPprcluKPjjbQHWSnZNKTs/xo5AkAsXoFBCi4Z3PTsuRLTfzTeH9h8f5hymMFQU35CnniTyhdAHjcOemV48Gq4LluDU+eXbwAZ/bRC7rQveNa3yO6BAkEAmR/rD6SWiK9k+FYmsGbcxbb00cr/92K5ik2NRUOUkSh7juTVucyGKtu4hkCPVg6hK7L2TAt6YE2tZl65JQoJqQ==";
		String value="彭宙硕";
		String sText = RSA.encode(key1, value);
		TestCase.assertEquals(value, RSA.decode(key2, sText));
	}
}
