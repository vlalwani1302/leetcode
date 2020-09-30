package leetcode.alice.string;

class ValidateIPAddress {
	public static void main(String[] args) {
		ValidateIPAddress ip = new ValidateIPAddress();
		System.out.println(ip.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
	}
	public String validIPAddress(String IP) {
		String type = "Neither";
		String splitChar = "";
		if (IP != null) {
			if (IP.indexOf(':') >= 0 && IP.indexOf(':') <= 4) {
				if(IP.endsWith(":"))
					return "Neither";
				type = "IPv6";
				splitChar = ":";
			} else if (IP.indexOf('.') >=0 && IP.indexOf('.') < 4) {
				if(IP.endsWith("."))
					return "Neither";
				type = "IPv4";
				splitChar = "\\.";
			}
		}

		String[] ips = IP.split(splitChar);

		if (type.equals("IPv4"))
			return isValidIPV4(ips);
		else if (type.equals("IPv6"))
			return isValidIPV6(ips);
		return type;
	}

	public String isValidIPV4(String[] ips) {
		if (ips.length != 4)
			return "Neither";
		for (String s : ips) {
			if (!s.equals("0") && s.startsWith("0"))
				return "Neither";
			int i = Integer.valueOf(s);
			if (i < 0 || i > 255) {
				return "Neither";

			}
		}
		return "IPV4";
	}

	public String isValidIPV6(String[] ips) {
        String hexdigits = "0123456789abcdefABCDEF";

    if(ips.length != 8)
        return "Neither";
    for(String s : ips){
        if(s.length() < 1 || s.length() > 4)
            return "Neither";
        for(int i=0; i<s.length(); i++){
                    if (hexdigits.indexOf(s.charAt(i)) == -1) return "Neither";

            
        }
    }
    
    return "IPv6";

}
}