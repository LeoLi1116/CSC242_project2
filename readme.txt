Chunhao Li
cli79@u.rochester.edu
CSC242 project2 CSP

How to build project:
javac *.java

running proejct:
java main [argument 1] [argument 2]
argument 1 is to specific which kind of CSP the file is.
argument 2 is the file path.
example:
java main job job.txt
java main map map.txt

For the job shop CSP, the task line should follow the procdure.
If the task bepends on previous task shows before its previous
task, my CSP solver for the job shop won't produce correct answer.
For the given example, 
AxelF AxelB WheelRF WheelLF WheelRB WheelLB NutsRF NutsLF NutsRB NutsLB CapRF CapLF CapRB CapLB Inspect
will get correct answer, but
Inspect AxelF AxelB WheelRF WheelLF WheelRB WheelLB NutsRF NutsLF NutsRB NutsLB CapRF CapLF CapRB CapLB
won't.

