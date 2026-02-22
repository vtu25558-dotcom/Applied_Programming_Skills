import java.util.*;

class Btrsv {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightmost = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightmost = node; // the last node at this level

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add the rightmost node of this level to result
            result.add(rightmost.val);
        }

        return result;
    }
}