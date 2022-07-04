
public class Uc_1_2_3Bst {
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	static Node root;

	Uc_1_2_3Bst() {
		root = null;
	}

	public static void main(String[] args) {

		Uc_1_2_3Bst tree = new Uc_1_2_3Bst();

		tree.insert(56);
		tree.insert(30);
		tree.insert(70);
		tree.insert(22);
		tree.insert(40);
		tree.insert(11);
		tree.insert(3);
		tree.insert(16);
		tree.insert(60);
		tree.insert(95);
		tree.insert(65);
		tree.insert(63);
		tree.insert(67);
		System.out.println(tree.getSize(root));
		tree.searchElement(tree.root, 63);

	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}

	public int getSize(Node root) {
		if (root == null)
			return 0;

		return 1 + getSize(root.left) + getSize(root.right);

	}

	public static boolean flag = false;

	public void searchElement(Node temp, int value) {
		if (root == null)
			System.out.println(value + "Empty tree");
		else {
			if (temp.key == value) {
				flag = true;
				System.out.println(value + "Is present in tree");
				return;

			}

			if (flag == false && temp.left != null)
				searchElement(temp.left, value);
			if (flag == false && temp.right != null)
				searchElement(temp.right, value);

		}
	}

}
