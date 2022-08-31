//Sink Method (saves nxn space of storing visited[][]): eg. isConnected = 1, notConnected = 0 -> when visited graph[i][j] == 1, change to graph[i][j] = 0

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//#32 - Longest Valid Parentheses
//Two directions search (from left to right AND from right to left)
public int longestValidParentheses(String s) {
    int left = 0, right = 0, maxlength = 0;
    for (int i=0; i<s.length(); i++) {
        if (s.charAt(i) == '(') {
            left++;
        }
        else {
            right++;
        }
        if (left == right) {
            maxlength = Math.max(maxlength, 2 * right);
        }
        else if (right >= left) {
            left = right = 0;
        }
    }
    left = right = 0;
    for (int i=s.length()-1; i>=0; i--) {
        if (s.charAt(i) == '(') {
            left++;
        }
        else {
            right++;
        }
        if (left == right) {
            maxlength = Math.max(maxlength, 2 * left);
        }
        else if (left >= right) {
            left = right = 0;
        }
    }
    return maxlength;
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//#199 - Binary Tree Right Side View
//Change the order of recursively calling rightSideViewHelper to get leftSideViewHelper

public List<Integer> rightSideView(TreeNode root) {
    List<Integer> resultList = new ArrayList<Integer>();
    rightSideViewHelper(root, resultList, 0);
    return resultList;
}
    
public void rightSideViewHelper(TreeNode root, List<Integer> resultList, int depth) {
    if (root == null) {
        return ;
    }
    else if (depth == resultList.size()) { //make sure the first element of that level will be added to the result list
        resultList.add(root.val);
    }
     
    rightSideViewHelper(root.right, resultList, depth+1);
    rightSideViewHelper(root.left, resultList, depth+1);
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//1161 - Maximum Level Sum of a Binary Tree

public void maxLevelSumHelper(TreeNode root, List<Integer> levelSums, int levelNum) { //note that the initial levelNum decides it is index-0 or index-1
    if (root == null) {
        return ;
    }
    else if (levelSums.size() == levelNum) { //never reached this level before
        levelSums.add(root.val);
    }
    else { //have reached this level
        levelSums.set(levelNum, levelSums.get(levelNum) + root.val);
    }
    
    //go to the next level
    maxLevelSumHelper(root.left, levelSums, levelNum+1);
    maxLevelSumHelper(root.right, levelSums, levelNum+1);
}
