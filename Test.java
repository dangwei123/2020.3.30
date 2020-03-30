给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>(0);
        }
        return generate(1,n);
    }
    private List<TreeNode> generate(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftTree=generate(start,i-1);

            List<TreeNode> rightTree=generate(i+1,end);

            
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
            
        }
        return list;
    }
}


二进制手表
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        int[] time={8,4,2,1,32,16,8,4,2,1};
        backtrack(num,time,0,0,0);
        Collections.sort(res);
        return res;
    }
    private void backtrack(int num,int[] time,int start,int hour,int min){
        if(num==0){
            if(hour>11||min>59){
                return;
            }
            StringBuilder sb=new StringBuilder();
            sb.append(hour);
            sb.append(":");
            if(min<10){
                sb.append("0");
            }
            sb.append(min);
            res.add(new String(sb));
            return;
        }

        for(int i=start;i<time.length;i++){
            if(i<4){
                hour+=time[i];
            }else{
                min+=time[i];
            }

            backtrack(num-1,time,i+1,hour,min);
            if(i<4){
                hour-=time[i];
            }else{
                min-=time[i];
            }
        }
    }
}

给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
class Solution {
    private List<String> res=new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        char[] c=S.toCharArray();
        backTrack(c,0);
        return res;
    }
    private void backTrack(char[] c,int index){
        if(index==c.length){
            res.add(new String(c));
            return;
        }
        if(c[index]<='9'&&c[index]>='0'){
            backTrack(c,index+1);
        }else{
            backTrack(c,index+1);

            c[index]^=32;
            backTrack(c,index+1);
        }

    }
}

给定一个 没有重复 数字的序列，返回其所有可能的全排列。

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums,List<Integer> row){
        if(row.size()==nums.length){
            List<Integer> tmp=new ArrayList<>(row);
            res.add(tmp);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(row.contains(nums[i])){
                continue;
            }
                row.add(nums[i]);
                backTrack(nums,row);
                row.remove(row.size()-1);
        }
    }
}

给定一个可包含重复数字的序列，返回所有不重复的全排列。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0) return res;
        Arrays.sort(nums);
        backTrack(nums,0,new boolean[nums.length],new ArrayList<>());
        return res;
    }
    private void backTrack(int[] nums,int index,boolean[] isVisited,List<Integer> row){
        if(index==nums.length){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!isVisited[i-1]){
                continue;
            }
            isVisited[i]=true;
            row.add(nums[i]);
            backTrack(nums,index+1,isVisited,row);
            isVisited[i]=false;
            row.remove(row.size()-1);
        }
    }
}

