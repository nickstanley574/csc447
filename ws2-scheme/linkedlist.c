#include <stdio.h>
#include <stdlib.h>


typedef struct node node;

struct node {
  int item;
  node *next;
};

node *new_node (int item, node *next) {
  node *result = (node*) malloc (sizeof (node));
  if (!result) {
    fprintf (stderr, "malloc failed");
    exit (1);
  }
  result->item = item;
  result->next = next;
  return result;
}

int sum_while (node *data) {
  int result = 0;
  while(data){
      result += data->item;
      data = data->next;
  }
  return result;
}

int sum_for (node *data) {
  int result = 0;
  for (; data; data = data->next){
      result += data->item;
  }
  return result;
}


int sum_recursive (node *data) {
  if (data == NULL){
      return 0;
  } 
  return sum_recursive (data->next) +  data->item;
}


int main (int argc, char **argv) {
  node *data = NULL;
  for (int i = argc - 1; i >= 1; i--) {
    data = new_node (atoi (argv[i]), data);
  }

  printf ("sum_while     = %d\n", sum_while (data));
  printf ("sum_for       = %d\n", sum_for (data));
  printf ("sum_recursive = %d\n", sum_recursive (data));
}