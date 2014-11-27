class Task < ActiveRecord::Base
  def mark_as_done!
    self.update_attributes(done: true)
  end
end
