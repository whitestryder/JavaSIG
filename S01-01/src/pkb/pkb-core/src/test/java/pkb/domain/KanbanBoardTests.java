/*
 * Classname : KanbanBoardTests
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

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JVANS
 * 
 */
public class KanbanBoardTests {

  private KanbanBoard _sut;

  @Before
  public void setup() {
    _sut = new SimpleKanbanBoard();
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddAnUnnamedTask() {
    _sut.addTask(new Task(""));
  }

  @Test
  public void itShouldAddANewTask() {

    _sut.addTask(new Task("my Task"));

    assertThat(_sut.findTask("my Task").isPresent())
      .describedAs("Unable to find the task").isTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddANullTask() {
    _sut.addTask(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddADuplicateTask() {
    Task myTask = new Task("my Task");
    _sut.addTask(myTask);
    _sut.addTask(myTask);

  }

  @Test
  public void itShouldFindAnExistingtask() {
    _sut.addTask(new Task("my Task"));

    assertThat(_sut.findTask("my Task").isPresent())
      .describedAs("Unable to find the task").isTrue();
  }
}
