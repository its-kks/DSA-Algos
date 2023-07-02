class node:
    def __init__(self, data):
        self.next = None
        self.prev = None
        self._value = data
    @property
    def value(self):
        return self._value
    @value.setter
    def value(self, data):
        self._value = data

class queueMid:
    def __init__(self):
        #using a dummy node
        self.head=node(None)
        self.mid=self.head
        self.tail=self.head
        self.count=0
    def enqueue(self,data):
        self.tail.next=node(data)
        self.tail.next.prev=self.tail
        self.tail=self.tail.next
        if(self.count%2==0):
            self.mid=self.mid.next
        self.count+=1
    def dequeue(self):
        if(self.count%2==0):
            self.mid=self.mid.next
        self.count-=1
        value=self.head.next._value
        self.head.next=self.head.next.next
        self.head.next.prev=self.head
        return value
    def deleteMid(self):
        value=self.mid._value
        pointer=self.mid
        if(self.count%2==0):
            self.mid=self.mid.next
        else:
            self.mid=self.mid.prev
        pointer.next.prev=pointer.prev
        pointer.prev.next=pointer.next
    def returnMid(self):
        if self.count==0:
            return None
        return self.mid._value
    def isEmpty(self):
        if self.count==0:
            return True
        else:
            return False

# Test Driver
if __name__ == "__main__":
    # Create a queueMid object
    queue = queueMid()

    # Enqueue elements
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)

    # Print the middle element
    print("Middle element:", queue.returnMid())  # Output: Middle element: 3

    # Dequeue an element
    print("Dequeued element:", queue.dequeue())  # Output: Dequeued element: 1

    # Print the middle element after dequeue
    print("Middle element:", queue.returnMid())  # Output: Middle element: 3

    # Delete the middle element
    queue.deleteMid()

    # Print the middle element after deletion
    print("Middle element:", queue.returnMid())  # Output: Middle element: 4

    # Check if the queue is empty
    print("Is the queue empty?", queue.isEmpty())  # Output: Is the queue empty? False
