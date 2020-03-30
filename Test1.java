给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
class Solution {
    List<String> res=new ArrayList<>();
    private String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return res;
        backTrack(digits,0,"");
        return res;
    }
    private void backTrack(String digits,int index,String s){
        if(index==digits.length()){
            res.add(s);
            return;
        }
        int pos=digits.charAt(index)-'0';
        String letters=map[pos];
        for(int i=0;i<letters.length();i++){
            backTrack(digits,index+1,s+letters.charAt(i));
        }
    }
}

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return res;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("(");
            
        }
        for(int i=0;i<n;i++){
            sb.append(")");
            
        }
        String s=new String(sb);
        backTrack(n,0,s,"",new boolean[2*n],0,0);
        return res;
    }
    private void backTrack(int n,int index,String s,String tmp,boolean[] isVisited, int left,int right){
        if(right>left){
            return;
        }
        if(index==2*n){
            res.add(tmp);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&s.charAt(i)==s.charAt(i-1)&&!isVisited[i-1]){
                continue;
            }
            tmp+=s.charAt(i);
            isVisited[i]=true;
            if(s.charAt(i)=='('){
                backTrack(n,index+1,s,tmp,isVisited,left+1,right);
            }else{
                backTrack(n,index+1,s,tmp,isVisited,left,right+1);
            }
            isVisited[i]=false;
            tmp=tmp.substring(0,index);
        }
    }
}

class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return res;
        backTrack(n,"",0,0);
        return res;
    }
    private void backTrack(int n,String s,int left,int right){
        if(right>left||left>n||right>n){
            return;
        }
        if(left==n&&right==n){
            res.add(s);
            return;
        }
        backTrack(n,s+"(",left+1,right);
        backTrack(n,s+")",left,right+1);
    }
}

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         if (candidates==null)return res;
        backTrack(candidates,0,target,new ArrayList<>(),0);
        return res;
    }
    private void backTrack(int[] arr,int sum,int target,List<Integer> row,int index){
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=index;i<arr.length;i++){
           
            row.add(arr[i]);
            backTrack(arr,sum+arr[i],target,row,i);
            row.remove(row.size()-1);
        }
    }


