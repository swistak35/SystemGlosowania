require 'test_helper'

class TaskTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
  test "marking as published" do
    t = Task.create
    assert t.done, false
    t.mark_as_done!
    assert t.done, true
  end
end
