#include <stdio.h>
#include <math.h>

int fun(int n) {
  int result = 0;
  for (int i = 1; i < n; i = i*2) {
    result += 1;
  } // for
  return result;
} // (int)

void
main (int argc, char *argv[])
{
  for (int n = 100; n < 400; n = n+10) {
    printf ("n=%d: fun(n)=%d\n", n, fun(n));
  } // for
} // main
