require 'test_helper'

class TaskAcceptanceTest < ActionDispatch::IntegrationTest
  setup do
    Task.delete_all
    User.create!(email: "user@example.com", password: "foobarbaz")

    visit "/users/sign_in"
    find("#user_email").set "user@example.com"
    find("#user_password").set "foobarbaz"
    first(:button, "Log in").click
  end

  test 'marks as done and undone' do
    visit '/tasks'
    assert page.has_content? "Listing tasks"

    first(:link, "New Task").click

    find("#task_name").set "SomeTask"
    select "10", from: "task_deadline_3i"
    first(:button, "Create Task").click
    assert page.has_content? "Task was successfully created."

    first(:link, "Back").click

    assert page.has_content? "SomeTask"
    assert !(page.has_content? "X")

    first(:link, "Mark as done").click

    assert page.has_content? "X"
    assert page.has_content? "Marked as done!"
  end
end
