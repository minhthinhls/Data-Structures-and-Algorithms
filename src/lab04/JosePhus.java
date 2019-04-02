/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

/**
 *
 * @author Minh Thinh
 */
public class JosePhus extends CircularLists {

    public int numberPeople;
    public int startAt;
    public int countOff;

    public JosePhus(int number, int start, int countOff) {
        super();
        this.numberPeople = number;
        this.startAt = start;
        this.countOff = countOff;
        // Insert n people to the circle.
        for (int i = 1; i <= number; i++) {
            this.insert(i);
        }
        // Choose the starting position in the circle.
        this.search(start);
    }

    /**
     * Override delete() method in CircularLists; Delete the current node and
     * the NEXT node becomes new current.
     */
    @Override
    public void delete() {
        System.out.println("$Delete current nodes, value: " + curr.data);
        Link next = curr.next;
        for (int i = 0; i < count - 1; i++) {
            curr = curr.next;
        } // Now current is the next node.
        curr.next = next;
        curr = curr.next;
        count--;
    }

    public static void main(String[] args) {
        JosePhus jp = new JosePhus(7, 1, 3);
        jp.displayAmount(10);
        while (jp.count > 1) {
            jp.step(jp.countOff);
            jp.delete();
        }
        jp.displayCurrentLink();
        jp.displayAmount(5);
    }
}
