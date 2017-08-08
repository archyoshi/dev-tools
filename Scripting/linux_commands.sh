#This is not a real shell script, it's only a file for saving useful commands

#A shell script starts with this : #!/bin/bash

Q:How to find a text in files ?
A:using "grep", do the following:

grep -rnw 'directory' -e "pattern"
-r or -R is recursive, -n is line number and -w stands match the whole word. -l (letter L) can be added to have just the file name.

Along with these, --exclude or --include parameter could be used for efficient searching. Something like below:

grep --include=\*.{c,h} -rnw 'directory' -e "pattern"
This will only search through the files which have .c or .h extensions. Similarly a sample use of --exclude:

grep --exclude=*.o -rnw 'directory' -e "pattern"
Above will exclude searching all the files ending with .o extension. Just like exclude file it is possible to exclude/include directories through --exclude-dir and --include-dir parameter, the following shows how to integrate --exclude-dir:

grep --exclude-dir={dir1,dir2,*.dst} -rnw 'directory' -e "pattern"
This works for me very well, to achieve almost the same purpose like yours.

For more options: man grep

