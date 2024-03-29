package edu.programacionavanzada.amlemartinez.ProyectoFinal.services;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.LogEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.keyvalue.core.query.KeyValueQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class LogEventService {

    private final KeyValueTemplate keyValueTemplate;

    public void save(LogEvent logEvent) {
        keyValueTemplate.insert(logEvent);
    }

    public Optional<LogEvent> get(UUID id) {
        return keyValueTemplate.findById(id, LogEvent.class);
    }

    public Iterable<LogEvent> fetchAll() {
        return keyValueTemplate.findAll(LogEvent.class);
    }

    public void update(LogEvent logEvent) {
        keyValueTemplate.update(logEvent);
    }

    public void delete(UUID id) {
        keyValueTemplate.delete(id, LogEvent.class);
    }

    public Iterable<LogEvent> getSortedListOfLogsBySalary() {
        KeyValueQuery<LogEvent> query = new KeyValueQuery<>();
        query.setSort(Sort.by(Sort.Direction.DESC, "dateTime"));
        return keyValueTemplate.find(query, LogEvent.class);
    }
}
