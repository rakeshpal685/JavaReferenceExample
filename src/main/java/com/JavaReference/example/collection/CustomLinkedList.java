package com.JavaReference.example.collection;

public class CustomLinkedList {

  CustomNode head, movingHead;

  int index = 0;

  public void insert(Object obj) { // Similar to add method
    CustomNode customNode = new CustomNode(obj, index);
    if (head == null) {
      head = movingHead = customNode;
    }
    /* else {//Below else is a simpler way
      CustomNode temp = head;
      while (temp.nextAddress != null) {
        temp = temp.nextAddress;
      }
      temp.nextAddress = customNode;
    }
    index++;*/
    else {
      movingHead.nextAddress = customNode;
      movingHead = customNode;
    }
  }

  public void insertBeforeHead(Object obj) { // Adding an element in the beginning of the linkedList
    CustomNode customNode = new CustomNode(obj, index);
    if (head == null) {
      head = customNode;
    } else {
      customNode.nextAddress = head;
      head = customNode;
    }
    index++;
  }

  public void insertAfterSpecificValue(Object data, Object afterNode) {
    CustomNode customNode = new CustomNode(data, index);
    if (head != null) {
      CustomNode tempHead = head;
      while (tempHead.nextAddress != null) {
        if (tempHead.data.equals(afterNode)) {
          CustomNode nextAddr = tempHead.nextAddress;
          tempHead.nextAddress = customNode;
          customNode.nextAddress = nextAddr;
          break;
        } else {
          tempHead = tempHead.nextAddress;
        }
      }
      if (tempHead.data.equals(afterNode)) {
        tempHead.nextAddress = customNode;
      }
    }
  }

  public void removeNode(Object obj) {
    if (head != null) {
      CustomNode temp = head;
      CustomNode previous = null;
      if (head.data.equals(obj)) {
        CustomNode tempHead = head.nextAddress;
        head.nextAddress = null;
        head = tempHead;
        return;
      }
      while (temp.nextAddress != null) {
        if (temp.data.equals(obj)) {
          CustomNode nextAddr = temp.nextAddress;
          previous.nextAddress = nextAddr;
          temp.nextAddress = null;
          break;
        } else {
          previous = temp;
          temp = temp.nextAddress;
        }
      }
      if (temp.data.equals(obj)) {
        previous.nextAddress = null;
        temp = null;
      }
    }
  }

  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("[");
    if (head == null) {
      return stringBuffer.toString().concat("]");
    } else {
      CustomNode temp = head;
      while (temp.nextAddress != null) {
        stringBuffer.append(temp.data + ",");
        temp = temp.nextAddress;
      }
      stringBuffer.append(temp.data);
    }
    return stringBuffer.toString().concat("]");
  }

  public Object get(int indexPassed) {
    if (indexPassed < 0 || indexPassed > index) {
      throw new RuntimeException("index not found");
    } else {
      if (head == null) {
        throw new RuntimeException("Linked List Empty");
      } else {
        CustomNode temp = head;
        while (temp.nextAddress != null) {
          if (temp.customNodeIndex == indexPassed) {
            return temp.data;
          } else {
            temp = temp.nextAddress;
          }
        }
        if (temp.customNodeIndex == indexPassed) {
          return temp.data;
        }
      }
    }
    return null;
  }

  /*This is an inner class, because each object is stored in a node form int the linked list, where every node contains at least 2 things, 1- the object
  that is to be stored and, 2- the address/reference of the next node, Here I have named my nodes as CustomNode*/
  class CustomNode {

    //The object that is to be stored in the node
    Object data;

    //The address/reference of the next node
    CustomNode nextAddress;

    //This is taken, incase I want to store the object at any specific index.
    int customNodeIndex;

    CustomNode(Object obj, int customNodeIndex) {
      this.data = obj;
      this.customNodeIndex = customNodeIndex;
    }
  }
}
