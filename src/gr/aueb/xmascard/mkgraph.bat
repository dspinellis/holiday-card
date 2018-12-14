ren UmlGraph-Java UmlGraph.java
javadoc -docletpath /dds/src/Research/umlgraph/lib/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -private -attributes -operations -nodefontsize 14 -edgefontsize 14 -nodefillcolor yellow *.java
ren UmlGraph.java UmlGraph-Java
dot -Tpng -ograph.png graph.dot
copy graph.png ..\..\..\..
