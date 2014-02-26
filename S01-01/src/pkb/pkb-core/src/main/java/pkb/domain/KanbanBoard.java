/*
 * Classname : KanbanBoard
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

import com.google.common.base.Optional;

/**
 * @author JVANS
 *
 */
public interface KanbanBoard {

  void addTask(Task newTask);

  /**
   * @param taskName
   * @return
   */
  Optional<Task> findTask(String taskName);

}

