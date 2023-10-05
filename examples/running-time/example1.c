#include <stdio.h>
#include <math.h>

int fun(int n) {
  int result = 0;
  for (int i = 1; i < n; i = i*2) {
    result += i;
  } // for
  return result;
} // (int)

void
main (int argc, char *argv[])
{
  for (int n = 10; n < 4000; n = n*2) {
    printf ("n=%d: fun(n)=%d, nlogn=%f\n", n, fun(n), n*log(n));
  } // for
} // main
