class Solution {
    public boolean isValid(String s) {
        // key --> close
        // value --> open 
        Map<Character,Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put(']','[');
        closeToOpen.put('}','{');
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(closeToOpen.containsKey(ch)){
                // closed brace
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    if(closeToOpen.get(ch)!=c)
                        return false;
                }
                else return false;

            }
            // open braces
            else{
                stack.push(ch);
            }
        }
    if(stack.isEmpty()) return true;
    else return false;
    }
}