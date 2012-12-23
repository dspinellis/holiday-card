javadoc -docletpath /dds/src/Research/umlgraph/lib/UmlGraph.jar -doclet gr.spinellis.umlgraph.doclet.UmlGraph -private -attributes -operations -nodefontname "Helvetica-Bold" -nodefontsize 14 -nodefillcolor yellow *.java
dot -Tpng -ograph.png graph.dot
