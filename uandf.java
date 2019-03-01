import java.util.ArrayList;

public class uandf<T> {
    private boolean finals_sets_method = false;
    public ArrayList<UFNode> rep;

    public uandf(int n) {
        // If  n is less than or equal to zero, there is no point to the unionfind
        if (n <= 0) {
            try {
                throw new Exception("Needs more than 0 elements");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // initializes length of unionfind
            this.rep = new ArrayList<UFNode>(n);
        }
    }

    // creates a new set whose only member (and thus rep) is i.
    public void make_set(T i) {
        // if final_sets() is called, cant make any more changes
        if (this.finals_sets_method == false) {
            UFNode<T> newNode = new UFNode<T>(i);
            newNode.parent = newNode; // At the start, assigns newNode's parent to itself
            rep.add(newNode);
        } else {
            System.out.println("Final Sets Method is called, this method won't make new changes");
        }
    }

    // unites the dynamic sets that contains i and j, respectively, into a new
    // set that is the union of these two sets.
    public void union_sets(T i, T j) {
        // if final_sets() is called, cant make any more changes
        if (this.finals_sets_method == false) {
            // Implements union by rank method
            UFNode<T> fRoot = find_set(i);
            UFNode<T> sRoot = find_set(j);

            // Just returns if they're equal because they have the same root
            if (fRoot.element.equals(sRoot.element)) return;

            // Does the comparsion mentioned in our lecture notes to assign rank
            if (fRoot.rank > sRoot.rank) {
                sRoot.parent = fRoot;
            } else if (sRoot.rank > fRoot.rank) {
                fRoot.parent = sRoot;
            } else {
                // For the case when ranks of both sets are equal
                fRoot.parent = sRoot;
                sRoot.rank = sRoot.rank + 1;
            }
        } else {
            System.out.println("Final Sets Method is called, this method won't make new changes");
        }
    }

    public UFNode<T> find_set(T i) {
        UFNode<T> res = null;
        for (int j = 0; j < rep.size(); j++) {
            if (rep.get(j).element == i) {
                res = findSetHelper(rep.get(j));
            }
        }
        if (res == null) {
            try {
                throw new Exception("No such element found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    private UFNode<T> findSetHelper(UFNode<T> node) {
        if (!node.parent.element.equals(node.element)) {
            return findSetHelper(node.parent);
        }
        return node;
    }


    public int final_sets() {
        // Pushes all the roots from 0 to final_sets()
        int count = 0;
        for (int i = 0; i < rep.size(); i++) {
            if (rep.get(i).parent.element.equals(rep.get(i).element)) {
                rep.add(0,rep.get(i));
                rep.remove(i+1);
                count++;
            }
        }
        this.finals_sets_method = true;
        return count;
    }
}
