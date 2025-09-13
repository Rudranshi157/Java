public class Strings{
    public static float getShortestPath(String path){
        int x = 0 , y = 0;
        for(int i = 0 ; i<path.length() ; i++){
            char dir = path.charAt(i);
            if(dir=='N'){
                y++;
            }
            else if(dir == 'S'){
                y--;
            }
            else if (dir == 'E'){
                x++;
            }
            else{
                x--;
            }    

        }
        int Y = y*y ;  
        int X = x*x ;
        return (float)Math.sqrt(X+Y);  
    }

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i = 1 ; i<str.length() ; i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){
        String newstr = "";
        for(int i =0 ; i<str.length() ; i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if(count>1){
                newstr+=count.toString();
            }
        }
        return newstr;
    }

    //hw
    //Question1:CounthowmanytimeslowercasevowelsoccurredinaStringenteredbytheuser
    public static void repeatitionOfVowels(String str){
        int len = str.length() ;
        int times = 0;
        String vowels = "aeiou" ;
        int n = vowels.length();
        for(int i = 0 ; i<len ; i++){
            for(int j = 0 ; j<n ; j++){
                if(str.charAt(i)==vowels.charAt(j)){
                    times++;
                    break;
                }
            }
        }
        System.out.println(times);
    }

    // Q2 to check if  2 strings are anagrams or not....
    public static boolean isAnagrams(String str1 , String str2){
        int len1 = str1.length() , len2 = str2.length(), c= 0;
        if(len1 != len2){
            return false;
        }
        String copy = str2;
        for(int i =0 ; i<len1 ; i++){
            for(int j= 0 ; j<copy.length() ; j++){
                if(str1.charAt(i)==copy.charAt(j)){
                    //System.out.println(copy.charAt(j));
                    Character m = copy.charAt(j);
                    copy = copy.replace(m.toString(),"" );
                    c++;
                    break;
                }
            
            }
        }
        
        if(c == str1.length()){
                return true;
            }else{
                return false;
            }
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));
        String str = "hi , i am sonu";
        //System.out.println(toUpperCase(str));
        String ab = "aaabbeeekkkkklll";
        //System.out.println(compress(path));
        // repeatitionOfVowels(str);
        // repeatitionOfVowels(ab);
        // repeatitionOfVowels(path);
        String a = "race" ;
        String b = "care" ;
        String c="Care" , g = "ghmdebme";
        //System.out.println(isAnagrams(c, b));

        

    }
}