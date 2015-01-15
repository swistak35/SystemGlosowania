require 'test_helper'

class HomeControllerTest < ActionController::TestCase
  setup do
    user = User.create(email: "user@example.com", password: "foobarbaz")
    sign_in user
  end

  test "should get index" do
    get :index
    assert_response :success
  end
end
