package myLinkedList;
//自定义链表实现
public class MyLinkedListTest {
	public static void main(String[] args) {
		 MyLinkedList linked = new MyLinkedList();  
	        linked.add(1);  
	        linked.add(2);  
	        linked.add(3);  
	        linked.add(4);
	        linked.add(5);
	        System.out.println(linked.get(1));
	        System.out.println(linked.get(2));
	        System.out.println(linked.get(3));
	        System.out.println(linked.get(4));
	        System.out.println(linked.get(5));
	        System.out.println(linked.get(6));
	          
	       /* linked.updata(5, 4);  
	        linked.insert(0, 0);  
	        linked.out();
	        System.out.println("=======");  
	        linked.delete(5);  
	      
	        linked.add(3);  
	        linked.out();  
	        linked.search(3);  */
	}
	
	static class Node{
		public int data;
		public Node next;
	}
	
	static class MyLinkedList{
		//定义头节点
		private Node head = new Node();
		//节点个数
		private int size = 0;
		
		//添加节点操作
		private void add(int val) {
			 Node node = new Node();  
		        node.data=val;  
		          
		        Node nextNode =new Node();  
		        nextNode=head;  
		        //找到为空的下一个节点  
		        while(nextNode.next!=null){
		            nextNode =nextNode.next;  
		        }  
		        nextNode.next=node;  
		        size++;  
		}
		 //插入节点操作  
	    public void insert(int value,int index){  
	        Node node = new Node();  
	        node.data=value;  
	        int count=0;  
	        Node nextNode = head;  
	        while(count<index){  
	            nextNode=nextNode.next;  
	            count++;  
	        }  
	        node.next=nextNode.next;  
	        nextNode.next=node;  
	          
	        size++;  
	    }  
	      
	    //得带指定位置的节点操作  
	    public int get(int index){  
	        Node nextNode = new Node();  
	        nextNode=head;  
	        int count=0;  
	        while(count<index){  
	            nextNode=nextNode.next;  
	            count++;  
	        }  
	        return nextNode.data;  
	    }  
	      
	    //查找元素  
	    public void search(int value){  
	        Node nextNode =new Node();  
	        nextNode=head;  
	        int count=0;  
	        while(nextNode.next!=null){  
	            if(nextNode.next.data==value){  
	                  
	                System.out.println("找到索引为"+count+"元素与待查找的元素相等！");  
	                nextNode=nextNode.next;  
	                count++;  
	              
	            }  
	            else{  
	                nextNode=nextNode.next;  
	                count++;  
	            }  
	        }  
	    }  
	      
	    //删除元素  
	    public void delete(int index){  
	        Node nextNode = new Node();  
	        nextNode=head;  
	        int count=0;  
	          
	        while(count<index){  
	            nextNode=nextNode.next;  
	            count++;  
	        }  
	          
	        nextNode.next=nextNode.next.next;  
	          
	        size--;  
	    }  
	      
	    //更新元素操作  
	    public void updata( int value,int index){  
	          
	          
	        Node nextNode = new Node();  
	        nextNode=head;  
	        int count=0;  
	          
	        while(count<=index){  
	            nextNode=nextNode.next;  
	            count++;  
	        }  
	          
	        nextNode.data=value;  
	      
	    }  
	      
	    //得到大小  
	    public int getSize(){  
	        return size;  
	    }  
	      
	    //遍历输出  
	    public void out(){  
	        Node nextNode = new Node();  
	        nextNode=head.next;  
	        while(nextNode!=null){  
	            System.out.println(nextNode.data);  
	            nextNode=nextNode.next;  
	        }  
	          
	    }  
	}
	
}


