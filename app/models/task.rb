class Task < ActiveRecord::Base
  def mark_as_done!
    self.update_attributes(done: true)
  end

  def unmark!
    self.update_attributes(done: false)
  end
end
