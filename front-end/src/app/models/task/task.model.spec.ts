import { TaskModel } from './task.model';

describe('Task', () => {
  it('should create an instance', () => {
    expect(new TaskModel(1, "", "", "todo")).toBeTruthy();
  });
});
