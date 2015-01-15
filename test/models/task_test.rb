require 'test_helper'

class TaskTest < ActiveSupport::TestCase
  test "marking as published" do
    t = Task.create
    assert_equal t.done, false
    t.mark_as_done!
    assert_equal t.done, true
    t.unmark!
    assert_equal t.done, false
  end
end
