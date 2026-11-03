class Solution {
    /*
        4#neet4#code
          l  
              r
    */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int l = 0;
        int r = 0;
        List<String> res = new ArrayList<>();

        while(r < str.length()){
            while(str.charAt(r) != '#'){
                r++;
            }

            int strLen = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            res.add(str.substring(l, l + strLen));
            r = l + strLen;
            l = r;
        }

        return res;
    }
    
}
