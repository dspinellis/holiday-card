ren UmlGraph-Java UmlGraph.java
javadoc -docletpath /dds/src/Research/umlgraph/lib/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -private -attributes -operations -nodefontsize 14 -nodefillcolor yellow *.java
dot -Tpng -ograph.png graph.dot
ren UmlGraph.java UmlGraph-Java
