# comporg2project
.data
prompt:  .asciiz  "Enter your howard id:"
base:	.asciiz "The base is:"
.text
main:

# prompt for the user to enter ID
# syscall for print
la $a0,prompt
li $v0,4
# load address of the prmpt
syscall

# read an integer from the user and store the result
li $v0,5
syscall
move $s0,$v0

#load divisor

li $t0,11
#divide howard id by 11
div $s0,$t0
#get the remiander
mfhi $s1


# add 26 to the remainder
li $s3,26
add $s1,$s1,$s3
#li $s3,10
#sub $s1,$s1,$s3

# print the result
la $a0,base
li $v0,4
syscall

li $v0,1
#load result
move $a0,$s1
syscall

#syscll for exit

li $v0,10
syscall

