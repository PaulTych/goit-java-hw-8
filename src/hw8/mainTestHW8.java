package hw8;

public class mainTestHW8 {
    public static void main(String[] args) {
        MyArrayList <String> array = new MyArrayList<>(String.class);
        String o1 = "Test";
        String o2 = "";
        System.out.println("----------------------Test ArrayList--------------------------------");
        System.out.println("Array before add: " + array);
        array.add(o1);
        array.add("Den");
        array.add("Vova");
        array.add("John");
        System.out.println("Array after add: " + array);
        System.out.println("Array size: " + array.size());
        o2 = array.get(2);
        System.out.println("Get 2nd element: " + o2);
        array.remove(2);
        System.out.println("Array after remove:" + array);
        array.clear();
        System.out.println("Array after clear:" + array);


        MyLinkedList <String> linkedList = new MyLinkedList<>();
        System.out.println("----------------------Test LinkedList------------------------------");
        System.out.println("LinkedList before add: " + linkedList);
        linkedList.add(o1);
        linkedList.add("Den");
        linkedList.add("Vova");
        linkedList.add("John");
        System.out.println("LinkedList after add: " + linkedList);
        System.out.println("LinkedList size: "+linkedList.size());
        o2=linkedList.get(2);
        System.out.println("Get 2nd element: "+o2);
        linkedList.remove(2);
        System.out.println("LinkedList after remove 2nd element:" + linkedList);
        linkedList.clear();
        System.out.println("LinkedList after clear:" + linkedList);

        MyQueue <String> queue = new MyQueue<>();
        System.out.println("----------------------Test Queue------------------------------");
        System.out.println("Queue before add: " + queue);
        queue.add(o1);
        queue.add( "Den");
        queue.add("Vova");
        queue.add("John");
        System.out.println("Queue after add: " + queue);
        System.out.println("Queue size: "+queue.size());
        o2 = queue.peek();
        System.out.println("Peek 2nd element: "+o2);
        o2 = queue.poll();
        System.out.println("Poll 2nd element: "+o2);
        queue.remove(2);
        System.out.println("Queue after remove:" + queue);
        queue.clear();
        System.out.println("Queue after clear:" + queue);

        MyStack <String> stack = new MyStack<>();
        System.out.println("----------------------Test Stack------------------------------");
        System.out.println("Queue before add: " + stack);
        stack.push(o1);
        stack.push( "Den");
        stack.push("Vova");
        stack.push("John");
        System.out.println("Stack after add: " + stack);
        System.out.println("Stack size: "+stack.size());
        System.out.println("Peek element: "+ stack.peek());
        stack.remove(2);
        System.out.println("Stack after remove 2nd element:" + stack);
        o2 = stack.pop();
        System.out.println("Pop element: "+o2);
        System.out.println("Stack after pop element:" + stack);
        stack.clear();
        System.out.println("Stack after clear:" + stack);

        MyHashMap <String,String> hashMap = new MyHashMap<>();
        System.out.println("----------------------Test HashMap------------------------------");
        System.out.println("HashMap before add: " + hashMap);
        hashMap.put("Test","class2a");
        hashMap.put("Den","class1a");
        hashMap.put("Vova","class1b");
        hashMap.put("John2","class2b");
        hashMap.put("Den2","class1a");
        hashMap.put("Vova2","class1b");
        hashMap.put("John3","class2b");
        System.out.println("HashMap after add: " + hashMap);
        System.out.println("HashMap size: "+hashMap.size());
        System.out.println("Get element Vova: "+ hashMap.get("Vova"));
        hashMap.remove("Vova");
        System.out.println("HashMap after remove Vova:" + hashMap);
        hashMap.clear();
        System.out.println("HashMap after clear:" + hashMap);
    }
}
