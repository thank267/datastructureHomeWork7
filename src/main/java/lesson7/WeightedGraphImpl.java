package lesson7;

import java.util.*;

public class WeightedGraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public WeightedGraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, Integer weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight; //!!!!!!!!!!!!

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        return false;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        return false;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (Objects.nonNull(adjMatrix[i][j])) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    public void dijkstra(String startLabel, String endLabel) {

        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }
        Vertex source = vertexList.get(startIndex);

        source.setDistance(0);

        Set<Vertex> settledVertexes = new HashSet<>();
        Set<Vertex> unsettledVertexes = new HashSet<>();

        unsettledVertexes.add(source);

        while (unsettledVertexes.size() != 0) {
            Vertex currentVertex = getLowestDistanceVertex(unsettledVertexes);
            unsettledVertexes.remove(currentVertex);
            for (int i = 0; i < getSize(); i++) {
                Vertex evaluationVertex = vertexList.get(i);

                Integer edgeWeight = adjMatrix[vertexList.indexOf(currentVertex)][i];
                if (Objects.nonNull(edgeWeight) && !settledVertexes.contains(evaluationVertex)) {
                    calculateMinimumDistance(evaluationVertex, edgeWeight, currentVertex);
                    unsettledVertexes.add(evaluationVertex);
                }
            }
            settledVertexes.add(currentVertex);
        }

        int endIndex = indexOf(endLabel);

        if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }
        Vertex result = vertexList.get(endIndex);

        System.out.println(result.getShortestPath());
        System.out.println(result.getDistance());
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (Objects.nonNull(adjMatrix[currentIndex][i]) && !vertexList.get(i).isVisited() ) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private Vertex getLowestDistanceVertex(Set<Vertex> unsettledVertexes) {
        Vertex lowestDistanceVertex = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertex vertex: unsettledVertexes) {
            int vertexDistance = vertex.getDistance();
            if (vertexDistance < lowestDistance) {
                lowestDistance = vertexDistance;
                lowestDistanceVertex = vertex;
            }

        }
        return lowestDistanceVertex;
    }

    private void calculateMinimumDistance(Vertex evaluationVertex,
                                                 Integer edgeWeigh, Vertex sourceVertex) {

        Integer sourceDistance = sourceVertex.getDistance();
        if (sourceDistance + edgeWeigh < evaluationVertex.getDistance()) {
            evaluationVertex.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Vertex> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());
            shortestPath.add(sourceVertex);
            evaluationVertex.setShortestPath(shortestPath);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }
}
