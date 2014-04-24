/*
 * Classname : KanbanBoardWithMockTests
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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;

/**
 * @author JVANS
 * 
 */
public class KanbanBoardWithMockTests {

  private KanbanBoard _sut;

  @Before
  public void setup() {
    _sut = mock(KanbanBoard.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddAnUnnamedTask() {
    _sut.addTask(new Task(""));
  }

  @Test
  public void itShouldAddANewTask() {
	when(_sut.findTask("my Task")).thenReturn(Optional.fromNullable(new Task("my Task")));
	
    _sut.addTask(new Task("my Task"));

    assertThat(_sut.findTask("my Task").isPresent())
      .describedAs("Unable to find the task").isTrue();
  }
  
 
  @Test
  public void itShouldNotFindATaskThatHasNotBeenAdded() {
    Optional<Task> absentTask = Optional.absent();
	when(_sut.findTask("my Task")).thenReturn(absentTask);
	
    _sut.addTask(new Task("my Task"));

    assertThat(_sut.findTask("my Task").isPresent())
      .describedAs("Unable to find the task").isFalse();
  }
  
  

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddANullTask() {
	doThrow(new IllegalArgumentException()).when(_sut).addTask(null);

	_sut.addTask(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldNotAddADuplicateTask() {
	
    Task myTask = new Task("my Task");

    doNothing().doThrow(new IllegalArgumentException()).when(_sut).addTask(myTask);
    
    _sut.addTask(myTask);
    _sut.addTask(myTask);

  }

  @Test
  public void itShouldFindAnExistingtask() {
	
	when(_sut.findTask("my Task")).thenReturn(Optional.fromNullable(new Task("my Task")));

    assertThat(_sut.findTask("my Task").isPresent())
      .describedAs("Unable to find the task").isTrue();
  }
}
