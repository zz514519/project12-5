class ListNode{
    ListNode next;
    int data;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class MySingList {
    ListNode head;

    public MySingList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插发
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //打印单列表
    public void display() {
        ListNode cur = this.head;
        if (this.head == null) {
            return;
        } else {
            while (cur != null) {
                System.out.println(cur.data + " ");
            }
            System.out.println();
        }
    }

    //任意位置插入，先要获取长度
    public int length() {
        ListNode cur = this.head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public boolean addIndex(int index, int data) {
        if (index < 0 || index > length()) {
            return false;
        } else {
            ListNode node = new ListNode(data);
            ListNode cur = this.head;
            if (index == 0) {
                addFirst(data);
            }
            while (index - 1 > 0) {
                cur = cur.next;
                index--;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    //查询是否含有key节点
    public boolean contains(int key) {
        ListNode cur = this.head;
        if (cur == null) {
            return false;
        } else {
            while (cur != null) {
                if (cur.data == key) {
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    //删除key节点,先要找前驱。
    public ListNode searchPrev(int key) {
        ListNode cur = this.head;
        if (cur == null) {
            return null;
        } else {
            while (cur.next != null) {
                if (cur.next.data == key) {
                    return cur;
                }
                cur = cur.next;
            }
        }
        return cur;
    }

    public void remove(int key) {
        ListNode cur = searchPrev(key);
        if (cur == null) {
            System.out.println("");
        } else {
            cur.next = cur.next.next;
        }
    }

    //删除所有的key节点
    public void removeAll(int key) {
        ListNode cur = this.head;
        ListNode node = new ListNode(0);
        node.next = this.head;
        while (node.next != null) {
            if (node.next.data == key) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        if (cur.next.data == key) {
            cur.next = null;
        }
    }

    //逆序单列表
    public ListNode reverseList() {
        ListNode cur = this.head;
        ListNode newHead = null;
        ListNode prev = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = cur.next;
        }
        return newHead;
    }

    //返回中间值
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        if (this.head == null) {
            return null;
        } else {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    //寻找倒数第K个节点
    public ListNode findKthToTail(int k) {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //以X为基准分割
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                //是不是第一次插入
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                //是不是第一次插入
                if (as == null) {
                    as = cur;
                    ae = as;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除重复节点，           思路：重新定义一个节点将不重复的节点连接在后面。
    public ListNode deleteDuplication() {
        if (this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
}