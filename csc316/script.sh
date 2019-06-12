#!/bin/bash

for f in test-files/input*.txt; do

    java -cp bin proj1 < $f >| $f.compressed.out

    java -cp bin proj1 < $f.compressed.out >| $f.decompressed.out

    diff $f $f.decompressed.out

    status=$?

    if [ $status -eq 0 ]

    then

        echo "TEST PASSED: $f"

    else

        echo "TEST FAILED: $f"

    fi

done