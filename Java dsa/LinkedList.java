public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public static Node head;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;
    public void addFirst(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        if(head ==null ){
            head = tail = newNode;
            return;
        }
        
        // newNode next = head
        newNode.next = head;

        // head = newnode
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int idx,int data){
        Node newNode = new Node(data);
        if(idx==0){
            addFirst(data);
            return;
        }
        size++;
        int i = 0;
        Node temp = head;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next= newNode;
    }
    public int removeFirst(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MAX_VALUE;
        }else if(size ==1){
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        size--;
        head = head.next;
        return val;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MAX_VALUE;
        }else if(size ==1){
            size=0;
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for(int i=0 ; i<size-2 ; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next =null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        int i=0;
        Node temp = head;
        while(temp!= null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        } 
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){    // tc and sc both --->O(n)
        return helper(head,key);
    }
    public void deleteNthFromEnd(int n){
        int sz=0;
        Node temp =head;
        while(temp!= null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head = head.next;
            return;
        }
        int i =1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev =prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        Node left = head;
        Node right = prev;

        while(right != null){
            if(right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        head = prev;
    }
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean ans = false;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ans = true;
                break;
            }
        }
        if(ans == false){
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null; // last node
        while(slow != fast){
            prev = fast;
            slow= slow.next;
            fast = fast.next;
        }
        //removing cycle
        prev.next = null;
    }
    private Node middleNode(Node head){
        Node slow = head;
        Node fast=head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node left , Node right){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(left!=null && right != null){
            if(left.data <= right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }
    public Node mergeSort(Node head){
        //base case
        if(head==null || head.next==null){
            return head;
        }
        //mid node 
        Node mid = middleNode(head);
        //left and right sorting
        Node righthead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);
        //left and right merging
        return merge(newLeft,newRight);
    }
    public void zigZag(){
        //find midNode
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //2nd half reverse
        Node curr=mid.next;
        mid.next = null;
        Node prev = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        Node nextR , nextL;

        //zigzag merge
        while(right != null && left != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next=nextL;
            //update
            right = nextR;
            left = nextL;
        }
    }
    public static Node findIntersection(Node head1 , Node head2){
        if(head1==head2){
            return head1;
        }
        Node temp = head1;
        Node temp2 = head2;
        while(temp != temp2){
            Node next = head1.next;
            Node next2 = head2.next;
            temp = next;
            temp2 = next2;
        }
        return temp;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList lb = new LinkedList();
        ll.addFirst(83);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        lb.addFirst(4);
        lb.addFirst(5);
        lb.addFirst(6);
        //ll.print();
        //ll.zigZag();
        lb.print();
        /*head = new Node(1);
        Node get = new Node(8); 
        get.next = new Node(3);
        //ll.addLast(3);
        get.next.next = new Node(4);
        get.next.next.next = get;*/
        // ll.addMiddle(2,9);
        //ll.print();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(30));
        // System.out.println(ll.recSearch(1));
        //System.out.println(ll.checkPalindrome());
        //ll.print();
        // ll.reverse();
        // ll.print();
        // boolean a=ll.checkPalindrome();
        // System.out.println(a);

   }
}