//list.c
//Singly linked list and test code

#include <stdio.h>
#include <stdlib.h>
// A node in a singly-linked list
struct node {
    int value;
    struct node *next;
};

// Head of the linked list
struct node *head;

// Insert a value into linked list
void list_insert(int v) {
    struct node *n;
    n = (struct node *)malloc(sizeof(struct node));
    n->value = v;
    n->next = head;
    head = n;
}

// Insert two values at once into linked list
void list_insert2(int a, int b) {
    struct node *u, *v; //made these pointers
	u = (struct node *)malloc(sizeof(struct node));//allocate mem
	v = (struct node *)malloc(sizeof(struct node));//allocate mem
    u->value = a; //u.value
    u->next = v; //u.next, take out &
    v->value = b; //v.value
    v->next = head; //v.next
    head = u; //took out &
}

// Remove an element from linked list
void list_remove(int v) {
    struct node *n = head;
    while(n && n->next && n->next->value != v) {
        n = n->next;
    }
    if(n && n->next && n->next->value == v) {
	struct node *temp; //create temp node and set to n->next
		temp = n->next;
        n->next = n->next->next;
		free(temp); //free temp instead
    }
}

// Print out all values in linked list
void list_printall(void) {
    struct node *p = head;
    int n = 0;
    while(p) {
		printf("%d ", p->value);
        p=p->next;
        n++;
        if(n > 100) break;
    }
    printf("\n");
}

// Deallocate all memory used in linked list
void list_destroy(void) {
	while(head->next) { //loop through and free entire list
		struct node *temp; //temp inside loop?
		temp = head;
		head = head->next;
		free(temp);
	}
	free(head);
}

int main(int argc, char *argv[]) {
    printf("Test linked lists\n");
    list_printall(); // Should print nothing
    list_insert(42);
    list_insert2(17, 10);
    list_insert(18);
    list_remove(10);
    list_printall(); // Should print 18 17 42
    // Cleanup memory
    list_destroy();
    return 0;
}
