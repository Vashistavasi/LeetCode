#!/bin/bash
simple_function() {
  for((i=0;i<5;++i))
  do
  echo -n " "$i" ";
  done
}

function without_braces {
  for((i=0;i<5;++i))
    do
    echo -n " "$i" ";
    done
}
simple_inputs() {
  echo "this is the first argument [$1]"
  echo "this is the second argument [$2]"
  echo "calling function with $# arguments"
}
#function simple_for_loop()
#  for((i=0;i<5;++i))
#  do
#  echo -n " "$i" ";
#  done
sum=0
simple_outpus() {
  sum=$(($1+$2))
}
ref_outputs() {
  declare -n sum_ref=$3
  sum_ref=$(($1+$2))
}
ref_outputs 1 2 sum
echo "sum is $sum"
simple_outpus 1 102
echo "sum is $sum"
simple_function
echo "\\\n second program"
without_braces
#simple_for_loop
simple_inputs one "two three"