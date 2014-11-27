Rails.application.routes.draw do
  devise_for :users
  resources :tasks do
    member do
      post 'mark'
    end
  end

  root 'home#index'
end
