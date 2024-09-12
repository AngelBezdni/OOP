package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Task2 {
    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();
        groups.add(new Group("Группа 1"));
        groups.add(new Group("Группа 2"));
        groups.add(new Group("Группа 3"));

        Stream stream = new Stream();
        stream.setGroups(groups);
    
        Comparator<Stream> comparator = new StreamComparator();
        System.out.println("Количество групп в первом потоке: " + stream.getGroups().size());
        System.out.println("Количество групп во втором потоке: " + stream.getGroups().size());
        if (comparator.compare(stream, stream) == 0) {
            System.out.println("Количество групп в обоих потоках одинаково");
        } else {
            System.out.println("Количество групп в обоих потоках различается");
        }
    
        Service service = new Service();
        List<Stream> sortedStreams = service.sortStreams(List.of(stream));
        for (Stream s : sortedStreams) {
            System.out.println(s.toString());
        }
    
        Controller controller = new Controller();
        controller.service = service;
        List<Stream> streams = controller.getSortedStreams();
        for (Stream s : streams) {
            System.out.println(s.toString());
        }
    }
}

class Group {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getName(), group.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Stream implements Iterable<Group> {
    private List<Group> groups;

    public Stream() {
        this.groups = new ArrayList<>();
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public Iterator<Group> iterator() {
        return groups.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Поток: ");
        groups.forEach(g -> builder.append(g.getName()).append(", "));
        return builder.substring(0, builder.length() - 2).toString();
    }
}

class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream a, Stream b) {
        return Integer.compare(a.getGroups().size(), b.getGroups().size());
    }
}

class Service {
    public List<Stream> sortStreams(List<Stream> streams) {
        List<Stream> sortedStreams = new ArrayList<>(streams);
        sortedStreams.sort(new StreamComparator());
        return sortedStreams;
    }
}

class Controller {
    Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public List<Stream> getSortedStreams() {
        return service.sortStreams(List.of(new Stream()));
    }
}