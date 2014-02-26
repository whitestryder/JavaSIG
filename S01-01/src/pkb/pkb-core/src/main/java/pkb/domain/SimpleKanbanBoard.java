/*
 * Classname : SimpleKanbanBoard
 * Project   : pkb-core
 * Version   : $Id$ 
 * Purpose   : 
 * 
 * Copyright (c) 2004-2014, MDA, All Rights Reserved
 * 
 * Author    Date        Issue#   Comments
 * --------- ----------- -------- -----------------------------------
 * 
 */

package pkb.domain;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Map;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * @author JVANS
 * 
 */
public class SimpleKanbanBoard implements KanbanBoard {

  private Map<String, Task> _tasks = Maps.newHashMap();

  /*
   * (non-Javadoc)
   * 
   * @see pkb.domain.KanbanBoard#addTask(pkb.domain.Task)
   */
  @Override
  public void addTask(Task newTask) {
    checkArgument(null != newTask);
    checkArgument(!Strings.isNullOrEmpty(newTask.getName()),
        "task must have a name");
    if (_tasks.containsKey(newTask.getName())) {
      throw new IllegalArgumentException("Task with name " + newTask.getName()
          + " is already on the board");
    }
    _tasks.put(newTask.getName(), newTask);
  }

  public Optional<Task> findTask(String taskName) {
    return Optional.fromNullable(_tasks.get(taskName));
  }
}
